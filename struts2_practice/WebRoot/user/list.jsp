<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "${pageContext.request.contextPath}/user/UserAction_add.do";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<s:form id="form1" name="form1" action="/user/UserAction_list.do" method="post">
		
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 条 件</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										用户姓名
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="userName" size="15" id="userName" cssClass="bg"></s:textfield>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										性别：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select name="sex" list="{'男','女'}" headerKey="" headerValue="--选择性别--"></s:select>
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										学历：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select name="education" list="{'博士','硕士','研究生','本科','专科','高中'}" headerKey="" headerValue="--选择学历--"></s:select>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										是否上传简历
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select name="isUpload" id="isUpload" list="#{1:'有',2:'无'}" headerKey="" headerValue="-是否上传--"></s:select>
									</td>
								</tr>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<s:submit type="button" id="search" name="search" value="查询" cssClass="button_view"></s:submit>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:reset type="button" name="reset" id="reset" value="重置" cssClass="button_view"></s:reset>
									</td>
								</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用 户 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<input type="button" value="添加" onclick="addUser()" class="button_view">
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										登录名
									</td>
									<td align="center" width="17%">
										用户姓名
									</td>
									<td align="center" width="8%">
										性别
									</td>
									<td align="center" width="23%">
										联系电话
									</td>
									<td width="11%" align="center">
										学历
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										查看
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<s:iterator value="#request.userList" var="user">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<s:property value="#user.loginName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#user.userName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:property value="#user.sex"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="23%">
												<s:property value="#user.telephone"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												<s:property value="#user.education"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/UserAction_edit.do?userID=<s:property value="#user.userID"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/UserAction_view.do?userID=<s:property value="#user.userID"/>">
													<img src="${pageContext.request.contextPath}/images/button_view.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/UserAction_delete.action?userID=<s:property value="#user.userID"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
		<s:debug></s:debug>
	</body>
</HTML>

