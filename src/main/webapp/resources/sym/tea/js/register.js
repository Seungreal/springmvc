var teacher = teacher || {}
teacher = (()=>{
	var init=()=>{
		'use strict';
$('.home').click(e=>{location.href=`${localStorage.getItem('ctx')}/`})
$('#facebook').click(e=>{location.href=`${localStorage.getItem('ctx')}/transfer/sym/tea/index`})
$('#signup-btn').click(e=>{
    e.preventDefault()
    $.ajax({
        url:'/teachers',
        type:'POST',
        data:JSON.stringify({
            name:$('#name').val(),
            password:$('#psw').val(),
            subject:$('#subject').val()
        }),
        dataType:'json',
        contentType:'application/json',
        success:d=>{
            if(d.message==='SUCCESS'){
                console.log('강사등록 성공')
            }
        },
        error:e=>{}
    })
})
	}
	return {init}
})()
