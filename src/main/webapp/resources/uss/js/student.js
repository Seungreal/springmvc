/**
 * 
 */
const userId = localStorage.getItem('searchId')
		$.getJSON(`/students/${userId}`,d=>{
			//userid,password,name,ssn,regDate,subject,profileImg
			$('#profileImg').html(`<img src="${d.profileImg}" alt="${d.name}" class="img-fluid rounded-circle mb-2" width="128" height="128" />
									<h5 class="card-title mb-0">${d.name}</h5>
									<div class="text-muted mb-2">Lead Developer</div>

									<div>
										<a id="info-update"class="btn btn-primary btn-sm" href="#">정보수정</a>
										<a id="info-delete"class="btn btn-danger btn-sm" href="#">정보삭제</a>
									</div>`)
			$('#subject').html(`<h5 class="h6 card-title" id="subject">수강과목</h5>
									<span id="updateSubject"><a href="#" class="badge badge-primary mr-1 my-1">${d.subject}</a></span>`)
			$('#about').html(`<h5 class="h6 card-title">About</h5>
									<ul class="list-unstyled mb-0">
										<li class="mb-1"><span data-feather="home" class="feather-sm mr-1"></span> 학생번호: <a href="#">${d.stuNum}</a></li>

										<li id="updateSsn"class="mb-1"><span data-feather="briefcase" class="feather-sm mr-1"></span> 생년월일: <a href="#">${d.ssn}</a></li>
										<li id="updateAddr"class="mb-1"><span data-feather="map-pin" class="feather-sm mr-1"></span> 주소: <a href="#">서울</a></li>
									</ul>`)
			$('#info-update').click(e=>{
				$('#updateSubject').html(`<input id="changeSubject" placeholder="${d.subject}"><br>
										<button id="updateConfirm"> 수정 확인 </button><button id="updateCancel"> 수정 확인 </button>`)
				$('#updateConfirm').click(e=>{
					$.ajax({
						url:'/students',
						type:'PUT',
						data:JSON.stringify({
							stuNum:d.stuNum,
							subject:$('#changeSubject').val()===''?d.subject:$('#changeSubject').val()
						}),
						dataType:'json',
						contentType:'application/json',
						success:d2=>{
							if(d2.message==='SUCCESS'){
								location.href='${ctx}/transfer/sym/mgr/student'
							}else{
								alert('수정 실패')
							}
						},
						error:e=>{}
					})
				})
			})
			$('#info-delete').click(e=>{
				$.ajax({
					url:'/students',
					type:'DELETE',
					data:JSON.stringify({
						stuNum:d.stuNum
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