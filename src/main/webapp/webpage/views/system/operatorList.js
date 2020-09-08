<%@ page contentType="text/html;charset=UTF-8" %>
<script>
    $(document).ready(function () {
        var operatortable = $("#operator-table").DataTable({
            //表示翻页时是否显示 processing信息（正在加载中），这个信息可以修改
            "processing": false,
            //bFilter: false,    //去掉搜索框方法三：这种方法可以
            searching : false, //去掉搜索框方法一：百度上的方法，但是我用这没管用
            "paging": true,//开启分页
            // 服务器端处理方式
            "serverSide": true,
            "ajax": {
                // url可以直接指定远程的json文件
                url: "${ctx}/system/operator/data",
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
                   console.log("打印请求参数："+ queryParams);
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
            "columns": [
                {
                    "orderable" : false,
                    title:'<input type="checkbox" class="checkAll"/>',
                    "render": function (data, type, full, meta) {
                        return '<input type="checkbox" class="checkchild"/>';
                    },
                    name:"id",
                },
                {
                    title:'ID',
                    data: 'id',
                    name: 'id',
                },
                {
                    title:'名称',
                    data: 'name',
                    name: 'name',
                },
                {
                    title:'出生日期',
                    data: function (data) {
                        return getMyDate(data.birthday);
                    },
                    name: 'birthday',
                },
                {
                    title:'地址',
                    data: 'address',
                    name: 'address',
                },
                {
                    title:'性别',
                    data: function (data) {
                        if(data.sex == 0){
                            return '男';
                        }else{
                            return '女';
                        };
                    },
                    name: 'sex',
                },
                {
                    title:'年龄',
                    data: 'age',
                    name: 'age',
                },{
                    title:'婚否',
                    data: function (data) {
                        if(data.isMarry == 0){
                            return '未婚';
                        }else{
                            return '已婚';
                        };
                    },
                    name: 'isMarry',
                },
                {
                    title:'爱好',
                    data: 'hobby',
                    name: 'hobby',
                },{
                    title:'特长',
                    data: 'specialty',
                    name: 'specialty',
                },
                {
                    title:'大学',
                    data: 'university',
                    name: 'university',
                },
                {
                    title:'电话',
                    data: 'phone',
                    name: 'phone',
                },
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
        alert("点我增加")
    };

    function edit() {
        alert("点我编辑")
    };

    function del() {
        alert("点我删除")
    };

    function view() {
        alert("点我查看")
    };
</script>
