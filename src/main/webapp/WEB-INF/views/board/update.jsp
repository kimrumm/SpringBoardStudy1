<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>
    <title>게시판 리스트</title>

    <script>
        // 게시판 이동
        $(document).ready(function () {
            $(".list").click(function () {
                location.href = "/board/list";
            });

            // 제출
            $("#submit").on('click', function (e) {
                e.preventDefault();
                $("form").submit();
            })

            $('#postContent').on('keyup', function () {
                $('#count').html("(" + $(this).val().length + " / 1000)");
                if ($(this).val().length > 1000) {
                    $(this).val($(this).val().substring(0, 1000));
                    $('#count').html("(1000 / 1000)");
                }
            });
        });

    </script>
</head>
<body>

<div class="container">
    <div class="mt-sm-5">
        <%@ include file="/WEB-INF/views/layout/nav.jsp" %>
    </div>
    <h2 class="mt-sm-5">게시글 수정 </h2>
    <form action="/board/update" name="form" id="form" method="post">
        <input type="hidden" name="bNo" value="${board.bNo}">
        <input type="hidden" name="gNo" value="${board.gNo}">
        <input type="hidden" name="step" value="${board.step}">
        <input type="hidden" name="indent" value="${board.indent}">
        <input readonly="readonly" type="text" class="form-control w-50 mb-sm-1" name="writer" value="${board.writer} ">
        <input readonly="readonly" type="text" class="form-control w-50 mb-sm-1" name="regDate" value="${board.regDate} ">
        <input readonly="readonly" type="text" class="form-control w-50 mb-sm-1" name="regDate" value="${board.editDate} ">
        <input type="text" class="form-control w-50 mb-sm-1" name="title" placeholder="제목" maxlength="100">
        <textarea rows="10" id="postContent" class="form-control w-50 mb-sm-1" name="content" maxlength="1000"></textarea>
        <div id="count">(0/1000)</div>

    </form>
    <button type="button" id="submit" class="btn btn-primary" style="margin-left: 45%;">등록</button>
    <button type="button" class="btn btn-primary list">목록</button>
</div>
</body>
</html>