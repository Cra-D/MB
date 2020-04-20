	function selop() {
		var rdo = document.getElementsByName("selAdd");
		var addcon = document.getElementById("addcon");
		var selcon = document.getElementById("selcon");
		if (rdo[0].checked == true) {
			addcon.disabled = true;
			selcon.disabled = false;
		} else {
			selcon.disabled = true;
			addcon.disabled = false;
		}
	}
	function setPar() {
		document.getElementsByName("flag")[0].value = "2";
		var sid = document.getElementsByName("stuid")[0].value;
		if (sid = "") {
			alert("您添加的学生学号为空");
			return false;
		}
	}
	function del(tem) {
		if (confirm("你将要删除学号为： " + tem.name + "的同学！")) {
			document.getElementsByName("flag_delUp")[0].value = 1;
			document.getElementsByName("parameter_del")[0].value = tem.name;
			alert("已经删除！");
		} else {
			document.getElementsByName("flag_delUp")[0].value = 3;
			document.getElementsByName("parameter_del")[0].value = "";
			alert("你取消了删除！");
			return false;
		}
	}
	function updata(tem) {
		document.getElementsByName("ud")[0].value = tem.name;

		document.getElementById("updateDiv").style.width = "auto";
		document.getElementById("updateDiv").style.height = "30px";
		document.getElementsByName("flag_delUp")[0].value = 2;
	}
	function checkPage(){
		var page=document.getElementsByName("page").value;
		if(page==""||page==null)return false;
	}
	function cancelupdate(){
		document.getElementById("updateDiv").style.height="0px";
	}
	  function switchTag(tag,content)
      {
//  alert(tag);
//  alert(content);
          for(i=1; i < 6; i++)
          {
              if ("tag"+i==tag)
              {
                  document.getElementById(tag).getElementsByTagName("a")[0].className="selectli"+i;
                  document.getElementById(tag).getElementsByTagName("a")[0].getElementsByTagName("span")
                      [0].className="selectspan"+i;
              }else{
                  document.getElementById("tag"+i).getElementsByTagName("a")[0].className="";
                  document.getElementById("tag"+i).getElementsByTagName("a")[0].getElementsByTagName("span")
                      [0].className="";
              }
              if ("content"+i==content)
              {
                  document.getElementById(content).className="";
              }else{
                  document.getElementById("content"+i).className="hidecontent";
              }
              document.getElementById("content").className=content;
          }
      }