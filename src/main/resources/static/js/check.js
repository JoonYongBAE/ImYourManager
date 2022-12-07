/** 팀 이름 중복 체크 및 글자수체크 
 * 
 */
  
 	function NameCheck() {		
	var name = document.getElementById("team_name");
	var width= 400;
	var height = 250;
	var left =Math.ceil((window.screenLeft - width)/2);
    var top=Math.ceil((window.screenTop -height)/2);

	
	
		if (name.value.length>10){			      //글자수확인
			alert("팀 이름은 10자 내로 입력해주세요.");
			cleartext();			
		} 
		else if(!name.value){                     // 팀이름 필수 입력하게 체크 
			alert("팀이름을 확인해주세요.")
		} else{
			
			window.open('NameCheck.jsp?t_name='+name.value,'', 
			'width='+width+', height='+height+', left='+left+',top='+top);     //중복확인창 작게 띄우기 ==> 화면 가운데 뜨게바꾸기 
		}
		
			
	}
	
	function checkValue(){    //입력값 다 썻는지 확인
		
		var form = document.newTeam;
		
		if(!form.t_name.value){
			alert("팀이름을 입력하세요.");
			return false;
		}
		if(form.idDuplication.value !="NameChecked"){
			alert("팀 이름 중복 확인을 해주세요.");
			return false;
		}
		if(!form.h_area1.value || !form.h_area2.value){
			alert("활동지역을 선택해주세요.");
			return false;
		}
		if(!form.t_age.value){
			alert("연령대를 선택해 주세요.");
			return false;
		}
		if(!form.t_type.value){
			alert("팀 유형을 선택해 주세요.");
			return false;
		}
		if(!form.t_level.value){
			alert("팀 실력을 선택해 주세요.");
			return false;
		}
	
		else{
			 confirm('등록하시겠습니까?','NewTeam_Process.jsp');
		}
	}
