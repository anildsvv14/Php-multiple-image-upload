<?php 
if ($_POST)
{
	$i=1;
    foreach ($_FILES['fileImage']['name'] as $f)
		{
			$file['name'] = $_FILES['fileImage']['name'][$i];
			$file['type'] = $_FILES['fileImage']['type'][$i];
			$file['tmp_name'] = $_FILES['fileImage']['tmp_name'][$i];
			$file['error'] = $_FILES['fileImage']['error'][$i];
			$file['size'] = $_FILES['fileImage']['size'][$i];
			//function for upload the images
			$mynewfile=move_uploaded_file($file['tmp_name'],"uploaded/".$file['name'])
			
			$i++;
			
			
		}
}
?>
<form method="post" action="" enctype="multipart/form-data" id="frmImgUpload">
    <input name="fileImage[]" type="file" multiple="true" />
    <br />
    <input name="btnSubmit" type="submit" value="Upload" />
</form>
