<%@ page contentType="text/html;charset=UTF-8" %>
<script>
    var $menutable;
    $(document).ready(function () {
        $menutable = $("#menu-table").treetable({
                    "theme":'vsStyle',
                    "expandLevel" : 1,
                    "column":0,
                    "expandable":true,//树是否可以展开，可以展开的树包含展开/折叠按钮。
                    "initialState":"collapsed",//初始状态，可选值: "expanded" or "collapsed".

                    beforeExpand:function($menutable,id){
                        alert("当前行id"+id)
                    },

                    onInitialized:function onInitialized() {

                    },//树初始化完毕后的回调函数.

                    onNodeCollapse:function onNodeCollapse(){

                    },//节点折叠时的回调函数.

                    onNodeExpand:function onNodeExpand(){

                    },//节点展开时的回调函数.

                    onNodeInitialized:function onNodeInitialized(){

                    },//节点初始化完毕后的回调函数
            });

        $("#search-btn").click(function () {
            var attribute = this.getAttribute('');
            if(attribute){
                alert("有这个变量")
            }else{
                alert("没这个变量");
                $("#search-form").close()
            }
        });
    });

    //将时间戳格式化
    function getMyDate(time){
        if(typeof(time)=="undefined"){
            return "";
        }
        var oDate = new Date(time),
            oYear = oDate.getFullYear(),
            oMonth = oDate.getMonth()+1,
            oDay = oDate.getDate(),
            oHour = oDate.getHours(),
            oMin = oDate.getMinutes(),
            oSen = oDate.getSeconds(),
            oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间

        return oTime;
    };

    //补0操作,当时间数据小于10的时候，给该数据前面加一个0
    function getzf(num){
        if(parseInt(num) < 10){
            num = '0'+num;
        }
        return num;
    };

    function add() {
        hk.open("${ctx}/system/menu/form/add","菜单新增");
    };

    function edit() {
        var id = hk.getSelectId();
        if(id.length > 1){
            alert("只能选择一条菜单信息进行编辑!!!")
        }else {
            hk.open("${ctx}/system/menu/form/edit?id="+id,"菜单编辑");
        }
    };

    function deleteAll() {
        var ids = hk.getSelectId();
        if(ids.length >= 1){
            var b = confirm("确认删除菜单信息吗？");
            if (b){
                hk.get("${ctx}/system/menu/deleteAll?ids="+ids,function (data) {
                    hk.info("删除成功");
                    operatortable.draw( false );/*重新绘制表格*/
                });
            }
        }
    };

    function view() {
        var id = hk.getSelectId();
        if(id.length > 1){
            alert("只能选择一条记录进行浏览!!!")
        }else {
            hk.open("${ctx}/system/menu/form/view?id="+id,"菜单浏览");
        }
    };
</script>
