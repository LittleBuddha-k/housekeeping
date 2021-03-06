<%@ page contentType="text/html;charset=UTF-8" %>
<script>
var dataTable;
var tree;
    $(document).ready(function () {
        dataTable  = $("#menu-table").DataTable({
            //表示翻页时是否显示 processing信息（正在加载中），这个信息可以修改
            "processing": false,
            //bFilter: false,    //去掉搜索框方法三：这种方法可以
            searching : false, //去掉搜索框方法一：百度上的方法，但是我用这没管用
            "paging": true,//开启分页
            // 服务器端处理方式
            "serverSide": true,
            "ajax": {
                // url可以直接指定远程的json文件
                url: "${ctx}/system/menu/data",
                type: 'POST',
                // 传给服务器的数据，可以添加我们自己的查询参数
                data: function (param) {
                    var queryParams;
                    var start = param.start;
                    var length = param.length;
                    var draw = param.draw;
                    var index =param.order[0].column;
                    var sort = param.order[0].dir;
                    var name = param.columns[index].name;
                    var orderBy = name + " " + sort;
                    queryParams = $("#query-form").serialize() + "&page.start=" + param.start + "&page.length=" + param.length + "&page.draw=" + param.draw + "&page.orderBy=" + orderBy;
                    console.log(queryParams);
                    return queryParams;
                },
                //用于处理返回数据
                "dataSrc": function(page) {
                    return page.data;
                },
                "dataFilter": function (page) {//json是服务器端返回的数据
                    page = JSON.parse(page);
                    var returnData = {};
                    returnData.draw = page.data.draw;
                    returnData.recordsTotal = page.recordsTotal;//返回数据全部记录
                    returnData.recordsFiltered = page.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                    returnData.data = page.data;//返回的数据列表
                    return JSON.stringify(returnData);//这几个参数都是datatable需要的，必须要
                }
            },
            //"ordering": true, //禁用排序
            "columns": [
                {
                    className: 'treegrid-control',
                    data: function (item) {
                        if (item.childrenMenus != null && item.childrenMenus.length > 0) {
                            return '<span> ++ </span>';
                        };
                        return '';
                    },
                    name:"name",
                },
                {
                    title:'ID',
                    data: 'id',
                    name:"id",
                },
                {
                    title:'名称',
                    data: 'name',
                    name:"name",
                },

                {
                    title:'父类ID',
                    data: 'parentId',
                    name:"parentId",
                },

                {
                    title:'父类群ID',
                    data: 'parentIds',
                    name:"parentIds",
                },
                {
                    title:'链接',
                    data: 'href',
                    name:"href",
                },
                {
                    title:'显示/隐藏',
                    data: 'isShow',
                    name:"isShow",
                },
                {
                    title:'排序',
                    data: 'sort',
                    name:"sort",
                },
                {
                    title:'菜单类型',
                    data: 'menuType',
                    name:"menuType",
                },
                {
                    title:'权限',
                    data: 'permission',
                    name:"permission",
                },
                {
                    title:'标签',
                    data: 'icon',
                    name:"icon",
                },

            ],
            "columnDefs": [
                {
                    "defaultContent": "",
                    "targets": "_all",
                    'targets' : [0,1],    //除第yi，第二两列外，默认排序
                    'orderable' : false
                }
            ],
            "oLanguage": {
                "sSearch": "搜索",
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                },
                "sProcessing": "正在加载数据......",
                "sZeroRecords": "没有检索到数据"
            },
            "lengthMenu": [[10, 25, 50, -1], ["10条", "25条", "50条", "全部"]],
            "pageLength": 10,
            "pagingType": "full_numbers",  //只显示翻页按钮只显示数字
            "scrollX": true,
        })
        /** 采用对象构建插件，方便我们调用插件内部方法 **/
        tree = new $.fn.dataTable.TreeGrid(dataTable,{
            left: 15,
            expandAll: true,
            expandIcon: '<span>++</span>',
            collapseIcon: '<span>--</span>'
        });
    })


function expandAll(){
    tree.expandAll();
}

function collapseAll(){
    tree.collapseAll();
}

function reload(){
    dataTable.ajax.reload();
}

function draw(){
    dataTable.draw(false);
}
</script>
