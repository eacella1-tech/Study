package com.kedu.commons;

public class Practice {
	public static void main(String[] args) {

		// Page Navigator 구현 방법
		// 신경 써야 할 데이터
		// 1. 총 게시글의 개수 : recordTotalCount
		// 2. 한 페이지 당 몇 개의 글을 보이게 할 것인지 : recordCountPerPage

		int recordTotalCount = 147;
		int recordCountPerPage = 10;

		// 위 2가지 정보로부터 총 페이지의 개수를 만들어 낼 수 있음.

		int pageTotalCount = 0;

		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		// 한 페이지에 네비게이션 개수를 몇개 보여줄건지 : NaviCountPerPage

		int naviCountPerPage = 10;

		// 현재 내가 위치한 페이지 번호 : currentPage

		int currentPage = 10;

		if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage-1);
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		System.out.println("현재 페이지 : " + currentPage);
		System.out.println("네비 시작 : " + startNavi);
		System.out.println("네비 끝 : " + endNavi);

		boolean needNext = true;
		boolean needPrev = true;

		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		if (needPrev) {
			System.out.print("< ");
		}

		for (int i = startNavi; i <= endNavi; i++) {
			System.out.print(i + " ");
		}

		if (needNext) {
			System.out.print(" >");
		}
	}
}
