<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title><spring:message code="diary.page.title" /></title>
    <link href="/static/css/styles.css" rel="stylesheet"/>
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous"/>
    <script src="/static/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
<script>

        const $diary = {
            DATA: {
            }, init: function () {
                $diary.event();
            }, event: function () {


                <c:choose>
                <c:when test="${isLogin == false}">
                $("body").attr("onclick","$diary.logoutEvent();");
                </c:when>
                <c:otherwise>

                </c:otherwise>
                </c:choose>

            }, logoutEvent(){
                alert("You can use it after logging in.");
                location.href = "/user/login"
            }
        };


</script>
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-vio">
    <a class="navbar-brand" href="index.html">오늘10초일기</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i>
    </button>
    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#!">Settings</a>
            <a class="dropdown-item" href="#!">Activity Log</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="login.html">Logout</a>
        </div>
    </ul>
</nav>
<div id="layoutSidenav">
    <form>
        <input type="hidden" value="${firstDay}" name="firstDay">
    </form>
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-vio" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">일기쓰기</div>
                    <a class="nav-link" href="index.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        금주 일기
                    </a>
                    <%--<div class="sb-sidenav-menu-heading">통계보기</div>
                    <a class="nav-link" href="charts.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                        Charts
                    </a>--%>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                Start Bootstrap
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <div class="card mb-4" style="margin-top: 5em;">
                   <%-- <div class="card-header">
                        일기 대표 문장.
                    </div>--%>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="weekDiary" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>시간</th>
                                    <th><span class="day">${days[0]}</span><span class="dayOfWeek">${dayOfWeeks[0]}</span></th>
                                    <c:forEach begin="1" end="6" varStatus="status">
                                        <th class="week" colspan="2"><span class="day">${days[status.index]}</span><span class="dayOfWeek">${dayOfWeeks[status.index]}</span></th>
                                    </c:forEach>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach begin="0" end="12" varStatus="status">
                                    <tr>
                                        <c:forEach begin="0" end="6" >
                                            <th class="time"><input type="number" class="form-control form-control-sm" placeholder="" name="" value="${status.index+7}"></th>
                                            <th class="week"><input type="text" class="form-control form-control-sm" placeholder="" ></th>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/static/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="/static/css/assets/demo/chart-area-demo.js"></script>
<script src="/static/css/assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
<script src="/static/css/assets/demo/datatables-demo.js"></script>
<script>
    window.onload = function() {
        $diary.init();
    }
</script>
</body>
</html>
