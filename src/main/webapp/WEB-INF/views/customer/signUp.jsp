<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Page Title - SB Admin</title>
    <link href="/static/css/styles.css" rel="stylesheet" />
    <script src="/static/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    <script>

        const $commonCall={
            ajax: function(method, url, datas , successCallback, failCallback){


                $.ajax({
                    url: url,
                    data: JSON.stringify(datas),
                    type: method,
                    xhrFields: {
                        withCredentials: true
                    },
                    datatype: 'json',
                    contentType: "application/json;charset=UTF-8",
                    beforeSend: function( xhr ) {
                        if(method.toLowerCase() == "post"){
                            const header = $("input[name='_csrf_header']").val();
                            const csrf = $("input[name='_csrf']").val();
                            xhr.setRequestHeader(header, csrf);
                        }
                    },
                    success: function (data) {
                        if(typeof successCallback == "function"){
                            successCallback(data);
                        }else{
                            alert(data);
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        if (jqXHR.responseJSON != null && typeof jqXHR.responseJSON.validData != "undefined"){
                            const filed =  jqXHR.responseJSON.errors[0].fieldName;
                            const message = jqXHR.responseJSON.errors[0].message;
                            alert(message);
                            $("#"+filed).focus();
                        }
                        if(typeof failCallback == "function"){
                            failCallback(jqXHR, textStatus, errorThrown);
                        }else{
                            alert( "Request failed: " + textStatus );
                        }
                    }
                });

            }
        };
        let $customerSignUp = {
            DATA: {
                onSignUp : false
            }, init: function () {
                $customerSignUp.event();

            }, event: function () {

                <c:choose>
                <c:when test="${true.equals(isLogin)}">
                location.href = "${customerLoginUrl}";
                </c:when>
                <c:otherwise>
                $(document).on("click", "#createAccount",function(){

                    let data = {};
                    data["email"]=$("#email").val();
                    data["password"]=$("#password").val();
                    data["confirmPassword"]=$("#confirmPassword").val();

                    if ($customerSignUp.DATA.onSignUp == true){
                        alert("회원가입이 진행중입니다. ");
                        return;
                    }
                    $customerSignUp.DATA.onSignUp = true;

                    $commonCall.ajax("POST", "${customerSignUp}" , data, function (result) {
                        alert("회원가입이 성공했습니다.");
                        $("#email").val("");
                        $("#password").val("");
                        $("#confirmPassword").val("");

                        $customerSignUp.loginEvent();

                    }, function (jqXHR, textStatus, errorThrown) {
                        $customerSignUp.DATA.onSignUp = false;
                    });
                });

                </c:otherwise>
                </c:choose>

            }, loginEvent(){
                location.href = "${customerLoginUrl}"
            }
        };


    </script>
</head>
<body class="bg-vio">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                            <div class="card-body">
                                <form id="sign-up" action="${customerSignUp}" method="POST">
                                    <div class="form-group">
                                        <label class="small mb-1" for="email">Email</label>
                                        <input class="form-control py-4" autocomplete="new-password" id="email" name="email" type="email" aria-describedby="emailHelp" placeholder="Enter email address" />
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="small mb-1" for="password">Password</label>
                                                <input class="form-control py-4" autocomplete="new-password" id="password" name="password" type="password" placeholder="Enter password" />
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="small mb-1" for="confirmPassword">Confirm Password</label>
                                                <input class="form-control py-4" id="confirmPassword" name="confirmPassword" type="password" placeholder="Confirm password" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group mt-4 mb-0"><a class="btn btn-primary btn-block" id="createAccount">Create Account</a></div>
                                    <input type="hidden" name="auth" value="ROLE_USER">
                                </form>
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <input type="hidden" name="_csrf_header" value="${_csrf.headerName}">
                            </div>
                            <div class="card-footer text-center">
                                <div class="small"><a href="${customerLoginUrl}">Have an account? Go to login</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <div id="layoutAuthentication_footer">
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Your Website 2021</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/static/js/scripts.js"></script>
<script>
    window.onload = function() {
        $customerSignUp.init();
    }

</script>
</body>
</html>
