<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <style>
      html, body {
      min-height: 100%;
      padding: 0;
      margin: 0;
      font-family: Roboto, Arial, sans-serif;
      font-size: 14px;
      color: #666;
      }
      h1 {
      margin: 0 0 20px;
      font-weight: 400;
      color: #1c87c9;
      }
      p {
      margin: 0 0 5px;
      }
      .main-block {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      background: #1c87c9;
      }
      form {
      padding: 25px;
      margin: 25px;
      box-shadow: 0 2px 5px #f5f5f5; 
      background: #f5f5f5; 
      }
      .fas {
      margin: 25px 10px 0;
      font-size: 72px;
      color: #fff;
      }
      .fa-envelope {
      transform: rotate(-20deg);
      }
      .fa-at , .fa-mail-bulk{
      transform: rotate(10deg);
      }
      input, textarea {
      width: calc(100% - 18px);
      padding: 8px;
      margin-bottom: 20px;
      border: 1px solid #1c87c9;
      outline: none;
      }
      input::placeholder {
      color: #666;
      }
      button {
      width: 30%;
      padding: 10px;
      border: none;
      background: #1c87c9; 
      font-size: 12px;
      font-weight: 400;
      color: #fff;
      }
      button:hover {
      background: #2371a0;
      }    
      @media (min-width: 568px) {
      .main-block {
      flex-direction: row;
      }
      .left-part, form {
      width: 50%;
      }
      .fa-envelope {
      margin-top: 0;
      margin-left: 20%;
      }
      .fa-at {
      margin-top: -10%;
      margin-left: 65%;
      }
      .fa-mail-bulk {
      margin-top: 2%;
      margin-left: 28%;
      }
      }
    </style>
<section id="data-mgt">
	<table  class="my-tab" id="mgr-tab">
		<tr>
    		<th  style="width: 30%">관리 항목</th><th id="result-form">조회결과</th>
    	</tr>
		<tr>
			<td>학 생 (총 <span id="stu-count"></span> 명) <button id="mgr-generate-db">DB생성</button><br/><br/>
    			<input type="text" id="stu-data-count" placeholder="인원수 입력"/><button id="mgr-insert-many-stu">ID 생성</button><br/><br/>
    			<button id="grd-register">성적입력</button><br/><br/>
	    		<input type="text" id="stu-data-update" placeholder="ID 입력"/><button>ID 검색</button><br/><br/>
	    		<input type="text" id="stu-data-delete" placeholder="ID 입력"/><button>ID 삭제</button><br/><br/>
	    		<input type="radio" name="stu-data-gender" value="M" checked="checked"/>남성
	    		<input type="radio" name="stu-data-gender" value="F" style="margin-left:20px"/>여성<button style="margin-left:38px">성별조회</button><br/><br/>
	    		<input type="text" id="stu-data-birthday" placeholder="년도입력" /><button>년도 이후 출생 </button> <!--  P.167 allMatch -->
	    		<input type="text" id="stu-data-birthday-after" placeholder="년도입력" /><button>년도 이전 출생 </button> <!--  P.167 noneMatch -->
	    		<input type="text" id="stu-data-subject" placeholder="수강과목 입력" /><button>수강과목별 학생 </button> <!--  P.168 findAny -->
	    		<input type="text" id="stu-data-young-man" placeholder="년도입력" /><button>최연소자 학생 </button> <!--  P.169 findFirst -->
	    		
    		
    		</td>
			<td id="mgr-data-mgt-stu">
				
			</td>
		</tr>
		<tr>
			<td>
				교강사
				<button>빅데이터생성</button>
				<button>조회</button>
				<button>수정</button>
				<button>삭제</button>
				<button>전체삭제</button>
			</td>
			<td>
			
			</td>
		</tr>
		<tr>
			<td>
				사원
				<button>빅데이터생성</button>
				<button>조회</button>
				<button>수정</button>
				<button>삭제</button>
				<button>전체삭제</button>
			</td>
			<td>
				
			</td>
		</tr>
	</table>
</section>
<script src="${mgr}/js/mgr.js"></script>
<script src="${stu}/js/stu.js"></script>
<script src="${cmm}/js/cmm.js"></script>
<script src="${sts}/js/grd.js"></script>
<script>
stu.count(`${ctx}`)

stu.list({ctx:`${ctx}`,pageSize: '10',pageNum:'1'})

$(`#grd-register`).click(function(){grd.register(`${ctx}`)})

$(`#mgr-generate-db`).click(function(){cmm.generateDB(`${ctx}`)})

stu.insertMany(`${ctx}`)
</script>
