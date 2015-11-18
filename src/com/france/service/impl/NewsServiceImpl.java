package com.france.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.france.bean.Article;
import com.france.bean.Lanmu;
import com.france.bean.Photo;
import com.france.dao.BaseDAO;
import com.france.service.NewsService;
import com.france.util.Config;
@Service("newsService")
public class NewsServiceImpl implements NewsService{
	@Resource
	private BaseDAO<Lanmu> lanmuDAO;
	@Resource
	private BaseDAO<Photo> photoDAO;
	@Resource
	private BaseDAO<Article> articleDAO;
	private List<Integer> leafArtilces;
	@Override
	public void saveLanmu(Lanmu m) {
		// TODO Auto-generated method stub
		lanmuDAO.save(m);
	}

	@Override
	public Lanmu findAllChildrenLanmu(int lanmu_id) {
		// TODO Auto-generated method stub
		Lanmu root=new Lanmu();
		root=lanmuDAO.get(Lanmu.class, lanmu_id);
		return root;
	}

	@Override
	public List<Lanmu> findBrotherLanmu(Lanmu currentLanmu) {
		// TODO Auto-generated method stub
		System.out.println("得到父栏目 start");
		Lanmu parentLanmu = currentLanmu.getParentLanmu();
		System.out.println("得到父栏目 end");
		if(parentLanmu==null)return null;
		String hql="select new Lanmu(lm.id,lm.name) from Lanmu as lm where lm.parentLanmu.id = ? and lm.id != ?";
//		lanmuDAO.executeHql(hql, param)
		return lanmuDAO.find(hql, new Object[]{parentLanmu.getId(),currentLanmu.getId()});
	}

	@Override
	public void savePhoto(Photo p) {
		// TODO Auto-generated method stub
		photoDAO.save(p);
		
	}

	@Override
	public void saveArticle(Article article) {
		// TODO Auto-generated method stub
		articleDAO.save(article);
	}

	@Override
	public void updateLanmu(Lanmu lm) {
		// TODO Auto-generated method stub
		lanmuDAO.update(lm);
	}

	@Override
	public List<Article> getAllChildLanmuArticleByPage(Lanmu parentLanmu,
			Integer pageNum) {
		// TODO Auto-generated method stub
		leafArtilces=new ArrayList<Integer>();
		dfs2getLeafchildren(parentLanmu);
		String in_sql=listToSQLString(leafArtilces);
		String hql="select new Article(a.id,a.title,a.publishTime) from Article as a where a.topicID in "+in_sql+" order by a.publishTime desc";
//		articleDAO.find(hql, new Object[]{}, pageNum, Config.PAGE_SIZE);//按分页加载
		return articleDAO.find(hql);//全部加载
	}
	private void dfs2getLeafchildren(Lanmu parentLanmu){
		//叶子节点
		if(parentLanmu.getChildren().size()==0){
			leafArtilces.add(parentLanmu.getId());
		}
		else{
			Iterator<Lanmu> iterator=parentLanmu.getChildren().iterator();
			while(iterator.hasNext()){
				Lanmu lanmuTemp=iterator.next();
				dfs2getLeafchildren(lanmuTemp);
			}
		}
	}
	private String listToSQLString(List<Integer> temp){
		String sql=" ( ";
		for(int i=0;i<temp.size();i++){
			if(i==0)sql+=temp.get(i);
			else sql+=","+temp.get(i);
		}
		sql+=" ) ";
		return sql;
	}

	@Override
	public Article findArticleByID(Integer id) {
		// TODO Auto-generated method stub
		return articleDAO.get(Article.class, id);
	}
}
