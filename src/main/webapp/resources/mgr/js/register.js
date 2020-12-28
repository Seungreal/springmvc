/**
 * 
 */
'use strict';
	
$('.move-home').click(e=>{location.href=`${localStorage.getItem('ctx')}/`})
$('#facebook').click(e=>{location.href=`${localStorage.getItem('ctx')}/transfer/sym/mgr/index`})
$('#signup-btn').click(e=>{
    e.preventDefault()
    $.ajax({
        url:'/managers',
        type:'POST',
        data:JSON.stringify({
            email:$('#email').val(),
            password:$('#psw').val()
        }),
        dataType:'json',
        contentType:'application/json',
        success:d=>{
            if(d.message==='SUCCESS'){
                location.href='${ctx}/transfer/sym/mgr/index'
            }
        },
        error:e=>{
            console.log(`관리자등록 실패:${e.responseText}`);
            location.href='${ctx}/move/cmm/404'
        }
        
    })
})
