<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sunhuapeng
  Date: 2020/5/16
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="card-body">
        <div class="form-group row">
            <label for="star" class="col-sm-2 col-form-label">星级：</label>
            <div class="col-sm-10">
                <input id="clubId" name="clubId" type="hidden" value="${club.clubId}">
                <input id="star" name="star" class="form-control" type="text" value="${club.star}">
            </div>
        </div>
    </div>
</body>
</html>
