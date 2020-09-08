<%@ page contentType="text/html;charset=UTF-8" %>
<script>
    $(document).ready(function () {
            var $menutable = $("#menu-table").treetable({
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
            })
    })
</script>
