<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<form action="" method="post">
	<table>
		<tbody>
			<tr>
				<td><label for="login-username" class="label_username">账号:</label></td>
				<td><input type="text" name="username"  id="login-username" class=input-box"></td>
			</tr>
			</br>
			<tr>
				<td><label for="login-password" class="label_pwd">密码:</label></td>
				<td><input type="password" name="password" value=""autocomplete"=off"
							id="login-password" class="input-box"></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td class="autologin-container">
				<input type="checkbox" value="1" id="login-auto">
				<label for="login-auto" class="login-auto-label">一周之内自动登录</label>
				<a target="_blank" href="" id="forget-password" class="login-forget-password">忘记密码</a>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="立即登录" id="ligin-submit">
					<input type="button" value="注册" id="login-register">
				</td>
			</tr>
		</tbody>
	</table>
</form>