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

tea.grade_mgt = x =>{
	$.getJSON(`${x.ctx}/teachers/page/${x.pageSize}/${x.pageNum}/subject/${x.subNum}/${x.examDate}`,d=>{
		const list = d.list
		const page =d.page
		$(`<h3/>`)
		.attr({id: `title`})
		.text(`${list[0].examDate} ${list[0].subject} 성적`)
		.appendTo(`#mgr-data-mgt-stu`)
		$(`<table/>`)
		.attr({id: `tab`})
		.css({width: `100%`})
		.appendTo(`#title`) 
		$(`<tr/>`).attr({id: `tr_1`}).appendTo(`#tab`)
		const arr = [`No`,`아이디`,`이름`,`생년월일`,`성별`,`점수`,`학점`]
		$.each(arr, function(i,j){
			$(`<th>${j}</th>`).css({backgroundColor: `gray`})
			.appendTo(`#tr_1`)
		})
		$.each(list, function(i, j){
			$(`<tr><td>${j.grdNum}</td>
		   	    		<td>${j.userid}</td>
		   	    		<td>${j.stuName}</td>
						<td>${j.birthday}</td>
						<td>${j.gender}</td>
						<td>${j.score}</td>
						<td>${j.grade}</td></tr>`)
						.css({padding: `15px`, textAlign: `left`, fontSize: `medium`})
						.appendTo(`#tab`)
		})
		$(`<div/>`)
		.addClass(`pagination`)
		.attr({id:`stu-page`})
		.appendTo(`#mgr-data-mgt-stu`)
		function* range(start,end){
			yield start;
			if(start === end) return;
			yield* range(start+1,end);
		}
		if(page.existPrev){
			$(`<a/>`)
			.attr({href:`#`})
			.text(`<<`)
			.appendTo(`#stu-page`)
			.click(e=>{
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				tea.grade_mgt({ctx:`${x.ctx}`,pageSize: '10',pageNum:page.prevBlock,subNum:'1',examDate:'2020-11-30'})
			})
		}
		$.each([...range(page.startPage,page.endPage)],(i,j)=>{
			$(`<a/>`)
			.attr({href:`#`})
			.css({backgroundColor:j!=page.pageNum?'white':'yellow'})
			.text(j)
			.appendTo(`#stu-page`)
			.click(e=>{
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				tea.grade_mgt({ctx:`${x.ctx}`,pageSize: '10',pageNum:j,subNum:'1',examDate:'2020-11-30'})
			})
		})
		if(page.existNext){
			$(`<a/>`)
			.attr({href:`#`})
			.text(`>>`)
			.appendTo(`#stu-page`)
			.click(e=>{
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				tea.grade_mgt({ctx:`${x.ctx}`,pageSize: '10',pageNum:page.nextBlock,subNum:'1',examDate:'2020-11-30'})
			})
		}
	})
}