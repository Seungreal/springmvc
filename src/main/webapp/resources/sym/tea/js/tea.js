var tea = tea || {}
tea.access = x=>{
	$.ajax({
		url: `${x}/teachers/access`,
		type: `post`,
		data: JSON.stringify({
			email: $(`#uid`).val(),
			password:$(`#pwd`).val()
			}),
		dataType: 'json',
		contentType: 'application/json',
		success: (d)=>{
			location.href = `${x}/tea/index`
		},
		error: (e)=>{
			alert(`Fail`)
		}
	})
	
}