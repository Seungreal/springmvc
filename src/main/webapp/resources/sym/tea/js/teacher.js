/**
 * 
 */
const userName = localStorage.getItem('searchName')
		$.getJSON(`/teachers/${userName}`,d=>{
			//teaNum,name,password,subject,email,profileImg
			$('#profileImg').html(`<img src="${d.profileImg}" alt="${d.name}" class="img-fluid rounded-circle mb-2" width="128" height="128" />
									<h5 class="card-title mb-0">${d.name}</h5>
									<div class="text-muted mb-2">교,강사</div>

									<div>
										<a id="info-update"class="btn btn-primary btn-sm" href="#">정보수정</a>
										<a id="info-delete"class="btn btn-danger btn-sm" href="#">정보삭제</a>
									</div>`)
			$('#subject').html(`<h5 class="h6 card-title" id="subject">강의과목</h5>
									<span id="updateSubject"><a href="#" class="badge badge-primary mr-1 my-1">${d.subject}</a></span>`)
			$('#about').html(`<h5 class="h6 card-title">About</h5>
									<ul class="list-unstyled mb-0">
										<li class="mb-1"><span data-feather="home" class="feather-sm mr-1"></span> 교사번호: <a href="#">${d.teaNum}</a></li>

										<li id="updateEmail"class="mb-1"><span data-feather="briefcase" class="feather-sm mr-1"></span> 이메일: <a href="#">${d.email}</a></li>
										<li id="updateAddr"class="mb-1"><span data-feather="map-pin" class="feather-sm mr-1"></span> 주소: <a href="#">서울</a></li>
									</ul>`)
			$('#info-update').click(e=>{
				$('#updateSubject').html(`<input id="changeSubject"type="text" placeholder="${d.subject}">`)
				$('#updateEmail').html(`이메일: <input id="changeEmail"type="text" placeholder="${d.email}">`)
				$('#updateAddr').html(`주소: <input id="changeAddr"type="text" placeholder="서울"><br>
										<button id="updateConfirm"> 확인 </button><button id="updateCancel"> 취소 </button>`)
				$('#updateConfirm').click(e=>{
					$.ajax({
						url:'/teachers',
						type:'PUT',
						data:JSON.stringify({
							teaNum:d.teaNum,
							subject:$('#changeSubject').val()===''?d.subject:$('#changeSubject').val(),
							email:$('#changeEmail').val()===''?d.email:$('#changeEmail').val()
						}),
						dataType:'json',
						contentType:'application/json',
						success:d2=>{if(d2.message==='SUCCESS'){
										location.href='${ctx}/transfer/sym/mgr/teacher'
									}else{
										alert('수정 실패!')
									}},
						error:e=>{}
					})
				})
			})
			$('#info-delete').click(e=>{
				$.ajax({
					url:'/teachers',
					type:'DELETE',
					data:JSON.stringify({
						teaNum:d.teaNum
					}),
					dataType:'json',
					contentType:'application/json',
					success:d2=>{
						if(d2.message==='SUCCESS'){
							location.href='${ctx}/transfer/sym/mgr/index'
						}else{
							alert('삭제 실패')
						}
					},
					error:e=>{}
				})
			})
		})