<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/user/menu.jsp" />

<style type="text/css">

.list-group-item {
  user-select: none;
}

.list-group input[type="checkbox"] {
  display: none;
}

.list-group input[type="checkbox"] + .list-group-item {
  cursor: pointer;
}

.list-group input[type="checkbox"] + .list-group-item:before {
  content: "\2713";
  color: transparent;
  font-weight: bold;
  margin-right: 1em;

}

.list-group input[type="checkbox"]:checked + .list-group-item {
  background-color: #0275D8;
  color: #FFF;
}

.list-group input[type="checkbox"]:checked + .list-group-item:before {
  color: inherit;
}

label {
	max-width: 100px;
	font-size: medium;
	max-width: 110px;	
	text-align: left;
}


i {
	font-size:50px;
}
</style>


<div class="col order-1">
<div class="container">
<div style="border: solid 1px; padding: 10px; text-align:center;">
 <h4> 회원정보수정 </h4>
</div>  
</div>
<br>
<div class="container" style="border: solid 1px; padding: 10px; text-align:center;">
<table>
<tr>
<td style="positon: absolute; padding-left: 50px;">프로필사진 </td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><i class="fas fa-child"></i></td>
</tr>
<tr>

<td style="positon: absolute; padding-left: 50px;">휴대폰번호</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${userPhone }" /></td>
</tr>
</table>
<br>
<table >
<tr>
<td style="positon: absolute; padding: 50px;">관심목록</td>
<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox1" />
  <label class="list-group-item" for="CheckBox1">Box1</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox2" />
  <label class="list-group-item" for="CheckBox2">Box2</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox3" />
  <label class="list-group-item" for="CheckBox3">Box3</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox4" />
  <label class="list-group-item" for="CheckBox4">Box4</label>
  
</div>
</td>

<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox5" />
  <label class="list-group-item" for="CheckBox5">Box5</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox6" />
  <label class="list-group-item" for="CheckBox6">Box6</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox7" />
  <label class="list-group-item" for="CheckBox7">Box7</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox8" />
  <label class="list-group-item" for="CheckBox8">Box8</label>

</div>
</td>

<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox9" />
  <label class="list-group-item" for="CheckBox9">Box9</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox10" />
  <label class="list-group-item" for="CheckBox10">Box10</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox11" />
  <label class="list-group-item" for="CheckBox11">Box11</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox12" />
  <label class="list-group-item" for="CheckBox12">Box12</label>

</div>

</td>
<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox13" />
  <label class="list-group-item" for="CheckBox13">Box13</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox14" />
  <label class="list-group-item" for="CheckBox14">Box14</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox15" />
  <label class="list-group-item" for="CheckBox15">Box15</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox16" />
  <label class="list-group-item" for="CheckBox16">Box16</label>

</div>

</td>
</tr>
</table>
<br>
<button type="button" id="btnUpdate" class="btn btn-dark">수정</button>
<button type="button" id="btnCancel" class="btn btn-dark">취소</button>
<br>
</div>
</div>

</div>

</div>
<br>
<br>
<br>
<br><br>
<br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
