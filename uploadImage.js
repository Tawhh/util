function PreviewImage(imgFile) {
		var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)/;
		if (!pattern.test(imgFile.value.toLowerCase())) {
			$("#logoImg").val(null);
		} else {
			var path;
			if (document.all)
			{
				imgFile.select();
				path = document.selection.createRange().text;
				document.getElementById("imgindexdiv1").innerHTML = "";
				document.getElementById("imgindexdiv1").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
						+ path + "\")";//使用滤镜效果 
			} else 
			{
				path = URL.createObjectURL(imgFile.files[0]);
				//	      document.getElementById("imgPreview").innerHTML = "<img class='preview-img' src='"+path+"'/>"; 
				$("#imgindexdiv1").html(
						"<img class='preview-img' src='"+path+"' style='width: 200px; height: 120px;'/>");
			}
		}
	}//图片上传结束