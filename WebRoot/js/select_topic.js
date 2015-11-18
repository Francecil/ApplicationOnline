$(document).ready(function(){
        $(".selectList").each(function(){
//            var url = "/ApplicationOnline/json/area2.json";
        	var url="news-showRootLanmu.action"
            var areaJson;
            var temp_html;
            var oProvince = $(this).find(".province");
            var oCity = $(this).find(".city");
            var oDistrict = $(this).find(".district");
            var province = function(){
                $.each(areaJson,function(i,province){
                    temp_html+="<option value='"+province.id+"'>"+province.name+"</option>";
                });
                oProvince.html(temp_html);
                city();
            };
            var city = function(){
                temp_html = ""; 
                var n = oProvince.get(0).selectedIndex;
                if((areaJson[n].children).length==0){
                    oCity.css("display","none");
                }else{
                 oCity.css("display","inline");
                 $.each(areaJson[n].children,function(i,city){
                    temp_html+="<option value='"+city.id+"'>"+city.name+"</option>";
                });
                oCity.html(temp_html);
                };
                district();
            };
            var district = function(){
                temp_html = ""; 
                var m = oProvince.get(0).selectedIndex;
                var n = oCity.get(0).selectedIndex;
                if(typeof(areaJson[m].children[n]) == "undefined"||(areaJson[m].children[n].children).length==0||typeof(areaJson[m].children[n].children) == "undefined"){
                    oDistrict.css("display","none");
                }else{
                    oDistrict.css("display","inline");
                    $.each(areaJson[m].children[n].children,function(i,district){
                        temp_html+="<option value='"+district.id+"'>"+district.name+"</option>";
                    });
                    oDistrict.html(temp_html);
                };
            };
            oProvince.change(function(){
                city();
            });
            oCity.change(function(){
                district();
            });
            $.getJSON(url,function(data){
                areaJson = data.children;
                province();
            });
        });
});

