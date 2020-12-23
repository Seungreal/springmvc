var init = ctx=>{
	alert(`${ctx}`)
	$('.move-home').click(e=>{location.href=`${ctx}/`})
	$('#manager-register').click(e=>{location.href=`${ctx}/transfer/sym/mgr/register`})
	$('#teacher-register').click(e=>{location.href=`${ctx}/transfer/sym/tea/register`})
	$('#sign-up').click(e=>{location.href=`${ctx}/move/uss/register`})
	$('#sign-in').click(e=>{location.href=`${ctx}/move/uss/login`})
	$('#linkedin').click(e=>{location.href=`${ctx}/home`})
}