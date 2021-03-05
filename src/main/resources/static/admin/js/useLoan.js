
    <!--时间格式化-->
    function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        h = date.getHours() + ':';
        m = date.getMinutes() + ':';
        s = date.getSeconds();
        return Y+M+D+h+m+s;
    };
 var table=new object();
    layui.use(['layer','jquery'], function(){ 

        $.ajax({
            url: url+'/useLoan/getUseLoan1',
            type: 'get',
            dataType: 'JSONP',
            jsonp: "callback", 
            jsonpCallback:"useLoanCallback",
            async: false,
            success:function (result) {
            // var str = "";//定义用于拼接的字符串
            $("#table").text(result.useLoanList[0]['id']);
            alert(result.useLoanList[0]['useLoan']);
             var dataArray = jQuery.parseJSON(result.userLoanList);
             table=dataArray;
            // showData(result);
            // for (var i = 0; i < result.useLoanList.length; i++) {
            //   //拼接表格的行和列
            //   str = "<tr><td>" + .result.useLoanList[i]['id'] + "</td><td>" + result.useLoanList[i]['useLoan'] + "</td></tr>";
            //   //追加到table中
            //   $("#tab").append(str);   
            // }
            },
        });
    });
 