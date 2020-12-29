/**
 * 
 */
var student = student || {}
student = (()=>{
	var init=()=>{
		'use strict';
		$('#home').click(e=>{location.href='${ctx}/'})
		$('#facebook').click(e=>{location.href='${ctx}/move/uss/profile'})
		$('#signup-btn').click(e=>{
    		e.preventDefault()
    		$.ajax({
	        url:'/students',
	        type:'POST',
	        data:JSON.stringify({
	            userid:$('#userid').val(),
	            name:$('#name').val(),
	            password:$('#psw').val(),
	            ssn:$('#ssn').val(),
	            regDate:$('#regDate').val(),
	            subject:$('#subject').val()
	        }),
	        dataType:'json',
	        contentType:'application/json',
	        success:d=>{
	            if(d.message==='SUCCESS'){
	                location.href='${ctx}/move/uss/login'
	            }
	        },
        	error:e=>{}
    })
})
	}
	return {init}
})()
