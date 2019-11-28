$(function(){
    $.ajax({
        url:'/selectProject',
        dataType:'json',
        success:function(data){
            for(let i=0;i<data.length;i++){
                let $tr=$('<tr></tr>');
                let last_update=new Date(Date.parse(data[i].last_update));
                let year=last_update.getFullYear();
                let month=(last_update.getMonth()+1)<10?"0"+(last_update.getMonth()+1):(last_update.getMonth()+1);
                let date=last_update.getDate()<10?"0"+last_update.getDate():last_update.getDate();
                let $tdNo=$('<td>'+data[i].no+'</td>');
                let $tdName=$('<td>'+data[i].name+'</td>');
                let $tdLanguages=$('<td>'+data[i].language+'</td>');
                let $tdLast_Update=$('<td>'+year+"-"+month+"-"+date+'</td>');
                let $tdStatus=$('<td class="T'+data[i].status+'">'+data[i].status+'</td>');
                let $tdUrl=$('<td><a href="'+data[i].url+'" target="_blank">'+data[i].url+'</a></td>');
                $tr.append($tdNo, $tdName, $tdLanguages, $tdLast_Update, $tdStatus, $tdUrl);
                $('#projectSheet').append($tr);
            }
        }
    });
});