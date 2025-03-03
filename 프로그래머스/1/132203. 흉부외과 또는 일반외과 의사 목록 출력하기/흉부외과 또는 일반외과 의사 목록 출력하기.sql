SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(hire_ymd, '%Y-%m-%d') AS HIRE_DATE
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY hire_ymd desc, dr_name asc;
