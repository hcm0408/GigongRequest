package com.onedaydent.gigongrequest.data.model;

import android.graphics.Bitmap;

import java.util.Date;

public class GigongStep2DTO {

    private static String TAG = GigongStep2DTO.class.getSimpleName();
    /* 기본정보 */
    private int gr_IDX;						// 인덱스
    private int gr_hall;					// 관
    private int gr_dr_mb_no; 				// Dr no
    private String gr_dr_mb_name;			// Dr 이름
    private int gr_mb_no; 					// 위생사 no
    private String gr_mb_name;				// 위생사 이름
    private int gr_gigong_mb_no;			// 기공사 no
    private String gr_gigong_mb_name;		// 기공사 이름
    private String gr_check_mb_no;			// 팀장 no
    private int gr_check_mb_name;			// 팀장 이름
    private String gr_Name;					// 환자성함
    private Date gr_RequestDate;			// 접수일
    private int gr_Gender;					// 성별 0 = 남자, 1 = 여자
    private String gr_ChartID;				// 차트번호
    private Date gr_CompleteDate;			// 완성일
    private String gr_CompleteDateTime;		// 완성일 시간
    private int gr_Complete;				// 0 = 작성, 1 = 확인, 2 = 완성
    private int gr_Type;					// 0 = 일반, 1 = 당일, 2 = 1박2일
    private int gr_isCheckComplete;         // 기공물 담당자 확인 0 미확인 1확인
    private String gr_IMGUrl;				// 펜으로 작성한 내용 IMG화
    private Bitmap tempBitmap;              // 펜트로 작성한 내용 임시 저장

    /* 옵션 */
    private int gr_Shade;					// 쉐이드
    private int gr_Check1;					// 바이트
    private int gr_Check2;					// 대합치
    private int gr_Check3;					// 지그
    private int gr_Check4;					// 동공사진
    private int gr_Check5;					// 지대치사진
    private int gr_Check6;					// 쉐이드사진
    private int gr_Check7;					// 당일 2nd op
    private int gr_Check8;					// gum porcelain
    private int gr_Check9;					// abut margin
    private int gr_Check10;					// face scan
    private String gr_WriteField;			// 글 작성 필드
    private int gr_Valid;					// 사용여부 0. 사용, 1. 삭제

    /* 피드백 영역 */
    private int gr_Contact;					// Contact 조절
    private int gr_Bite;					// Bite 조절
    private int gr_CementType;				// Cement Type 조절
    private int gr_ScrewHole;				// Screw Hole 조절

    private String gr_RequestDateTemp;
    private String gr_CompleteDateTemp;
}
