<%@ page contentType="text/html;charset=UTF-8" %>
<script>
var $menutable=null;
$(document).ready(function(){
    $menutable=$('#menu-table').treeTable({
        theme:'vsStyle',
        expandLevel : 1,
        column:0,
        checkbox: false,
        url:'${ctx}/system/menu/data?parentId=',
        callback:function(item) {
            item.isShow = (item.isShow == '1'?true:false);
            if(item.href&&item.href.length>4){
                item.hideFullName = item.href.substring(0,4)+"...";
            }else if(item.href == undefined){

            }else{

            }
            if(item.permission&&item.permission.length>4){
                item.hidePermission = item.permission.substring(0,4)+"...";
            }else if(item.permission == undefined){
                item.hidePermission = "";
            }else{
                item.hidePermission = item.permission;
            }
            /*var menuItemTpl= $("#menuItemTpl").html();
            var result = laytpl(menuItemTpl).render(item);
            return result;*/
        },
        beforeClick: function($treeTable, id) {
            //异步获取数据 这里模拟替换处理
            $treeTable.refreshPoint(id);
        },
        beforeExpand : function($treeTable, id) {

        },
        beforeClose : function($treeTable, id) {

        }
    });


});
</script>
