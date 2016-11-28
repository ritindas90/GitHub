<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jersey-Upload-Download-Excel-Files</title>
</head>
<body style="align: center">
	<b>Data Loader</b>
	<br />
	<br />
	<h4>Download file</h4>
	<div
		style="width: 400px; border: 1px solid blue; padding: 20px; text-align: center;">

		<form method="get" action="rest/file/downloadDigitalAsset"	enctype="multipart/form-data">
			<table align="center" border="1" bordercolor="black" cellpadding="0"
				cellspacing="0">
				<tr><td><input type="submit" value="Download File" /></td></tr>
			</table>
		</form>
	</div>
	<h4>Uploading file</h4>
	<div
		style="width: 400px; border: 1px solid blue; padding: 20px; text-align: center;">

		<form method="post" action="rest/file/uploadDigitalAsset" enctype="multipart/form-data" >
			<table align="center" border="1" bordercolor="black" cellpadding="0"
				cellspacing="0">
				<tr>
					<td>Select File :</td>
					<td><input type="file" name="file" size="100"  accept=".xlsx" multiple="multiple"/></td>
				</tr>
				<tr>
					<td>Select File :</td>
					<td><input type="file" name="file" size="100"  accept=".xlsx" multiple="multiple"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Upload File" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>