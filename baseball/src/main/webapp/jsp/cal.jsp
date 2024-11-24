<%@page import="java.util.List"%>
<%@page import="com.baseball.service.BaseballService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/css/datepicker.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/datepicker.min.js"></script>
<style>

</style>
</head>
<body>
	<p>Date: <input type="text" class="datepicker_input form-control border-2" id="input-date" ></p>

<script>
function generateAllDates(startDate, endDate) {
    const dates = [];
    let currentDate = new Date(startDate);

    // 종료 날짜까지 반복
    while (currentDate <= new Date(endDate)) {
        // 날짜를 문자열로 변환 (yyyy-mm-dd 형식)
        dates.push(currentDate.toISOString().split('T')[0]);
        // 하루를 더함
        currentDate.setDate(currentDate.getDate() + 1);
    }

    return dates;
}
const startDate = "2024-01-01"; // 시작 날짜
const endDate = "2024-12-31";   // 종료 날짜

// 전체 날짜 목록 생성
const allDates = generateAllDates(startDate, endDate);
const selectableDates = ["2024-11-01", "2024-11-15", "2024-11-25"];
const datesDisabled = allDates.filter(date => !selectableDates.includes(date));
const elem = document.querySelector('#input-date');

// Datepicker 초기화
const datepicker = new Datepicker(elem, {
    format: 'yyyy-mm-dd',
    datesDisabled: datesDisabled
});

</script>
</body>
</html>