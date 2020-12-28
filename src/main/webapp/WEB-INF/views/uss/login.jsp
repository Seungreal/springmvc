<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
    body {font-family: Arial, Helvetica, sans-serif;}
    * {box-sizing: border-box}
    
    /* Full-width input fields */
    input[type=text], input[type=password] {
      width: 100%;
      padding: 15px;
      margin: 5px 0 22px 0;
      display: inline-block;
      border: none;
      background: #f1f1f1;
    }
    
    input[type=text]:focus, input[type=password]:focus {
      background-color: #ddd;
      outline: none;
    }
    
    hr {
      border: 1px solid #f1f1f1;
      margin-bottom: 25px;
    }
    
    /* Set a style for all buttons */
    button {
      background-color: #4CAF50;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer;
      width: 100%;
      opacity: 0.9;
    }
    
    button:hover {
      opacity:1;
    }
    
    /* Extra styles for the cancel button */
    .cancelbtn {
      padding: 14px 20px;
      background-color: #f44336;
    }
    
    /* Float cancel and signup buttons and add an equal width */
    .cancelbtn, .signupbtn {
      float: left;
      width: 50%;
    }
    
    /* Add padding to container elements */
    .container2 {
      padding: 16px;
    }
    
    /* Clear floats */
    .clearfix::after {
      content: "";
      clear: both;
      display: table;
    }
    
    /* Change styles for cancel button and signup button on extra small screens */
    @media screen and (max-width: 300px) {
      .cancelbtn, .signupbtn {
         width: 100%;
      }
    }
</style>

<section id="coming-soon">        
    <div class="container">
       <div class="row">
           <div class="col-sm-8 col-sm-offset-2">                    
           </div>
           <div class="col-sm-12">
               <h1>학습자 로그인화면</h1>
               <form style="border:1px solid #ccc">
                   <div class="container2">
                     <h1>Sign in</h1>
                     <p>Please fill in this form to create an account.</p>
                     <hr>
                       
                     <label for="userid"><b>아이디</b></label>
                     <input type="text" placeholder="아이디 입력" id="userid" required>

                     <label for="psw"><b>비밀번호</b></label>
                     <input type="password" value="123" id="psw" required>

                     <!-- <label>
                       <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                     </label> -->
                     
                     <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
                  
                      <div class="clearfix">
                        <button type="button" class="cancelbtn">Cancel</button>
                        <button type="submit" id="signin-btn" class="signupbtn">Sign in</button>
                      </div>
                    </div>
                </form>
            </div>
        </div>
    </div>       
</section>



