<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<div>
  <h3> Choose File to Upload in Server </h3>
  <%--<form method="POST" action="upload" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" /> <br/>
    &lt;%&ndash;Destination:
    <input type="text" value="/tmp" name="destination"/>&ndash;%&gt;
    </br>
    <input type="submit" value="Upload" name="upload" id="upload" />
  </form>--%>


  <form method="POST" action="upload" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" /> <br/>

    <input type="submit" value="Upload" name="upload" id="upload" />
  </form>
  <br/><br>

  <form method="POST" action="uploadCommons" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="fileC" /> <br/>

    <input type="submit" value="Upload" name="upload" id="uploadC" />
  </form>


</div>

</body>
</html>