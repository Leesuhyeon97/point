package com.triple.point.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.point.dao.ReviewDAO;
import com.triple.point.vo.ReviewVO;
import com.triple.point.enums.*;

@Service
public class ReviewService {

    @Transactional
    public boolean getReviewPoint(ReviewVO reviewVO) {
        int reviewPoint = 0;

        switch (reviewVO.getAction()) {
            case ActionEnums.ADD:
                // 신규 사용자의 리뷰 작성시

                // 리뷰를 작성했을 때 포인트를 계산하는 부분
                reviewPoint = calReviewPoint(reviewVO.getContent(), reviewVO.getAttachedPhotoIds(),
                        reviewVO.getPlaceId());

                break;
            case ActionEnums.MOD:
                // 리뷰를 수정했을 때 포인트를 계산하는 부분

                break;
            case ActionEnums.DELETE:
                // 리뷰를 삭제했을 때 포인트를 계산하는 부분
                break;

            default:
                break;
        }
        return true;
    }

    private int calReviewPoint(String content, String[] attachedPhotoIds, String placeId) {
        int reviewPoint = 0;

        // 해당 장소의 첫번째 리뷰 작성 시

        // 1글자 이상 리뷰 작성시
        if (content.length() > 0) {
            reviewPoint += 1;
        }
        // 1장 이상 사진 첨부 시
        if (attachedPhotoIds.length > 0) {
            reviewPoint += 1;
        }

        return reviewPoint;
    }

}