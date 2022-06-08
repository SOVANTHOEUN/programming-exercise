package teststring;

public class TEST_REPLACE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String descriptionStr = "\"introduction\": \"\\\"산중에 묻혀 있는 우물 같은 호수\\\" 산정호수와 이 산정호수를 병풍처럼 두르고 있는 명성산과 관음산! 아름경관에 눈이 아름다워지는 곳! 봄부터 가을까지는 수상레저를 즐길 수 있고 겨울에는 얼음 썰매장으로 사계절 사랑을 받는 곳에 숲속의 행복마을이 있습니다. 넓은 호수가 펼쳐진 상정호수에서 즐거운 수장레저를 즐기며 눈앞에 펼쳐진 아름다운 풍경을 친구삼아 즐거운 드라이브는 또 하나의 즐거움입니다. 가족과 함께 오순도순 오붓한 바비큐파티와 복잡한 도시를 떠나 한적한 계곡에서 편한한 휴식 이 모든 것을 숲속의 행복마을에서 즐길 수 있습니다. 오시는 모든 손님을 소중한 인연으로 생각하며 편안한 휴식이 될 수 있도록 내 가족이라는 생각으로 최선을 다해 모시겠습니다.\"";
		
		System.out.println("descriptionStr::: "+descriptionStr.replaceAll("\r\n|\r|\n", " "));
	}

}
