/**
 * 
 */
var manager = manager || {}
manager=(()=>{
	const _=localStorage.getItem(`ctx`)
	const init=()=>{
		'use strict';	

		$('.move-home').click(e=>{location.href=`${_}/`})
		$('#facebook').click(e=>{location.href=`${_}/transfer/sym/mgr/index`})
		
		signUp()
	}
	const signUp=()=>{
		
		$('#signup-btn').click(e=>{
			alert(`관리자 등록`)
		    e.preventDefault()
		    $.ajax({
		        url:`${_}/managers/`,
		        type:'POST',
		        data:JSON.stringify({
		            email:$('#email').val(),
		            password:$('#psw').val()
		        }),
		        dataType:'json',
		        contentType:'application/json',
		        success:d=>{
		            if(d.message==='SUCCESS'){
		                location.href=`${_}/transfer/sym/mgr/index`
		            }
		        },
		        error:e=>{
		            console.log(`관리자등록 실패:${e.responseText}`);
		            location.href=`${_}/move/cmm/404`
		        }
		        
		    })
		})
	}
	return {init}
})()
