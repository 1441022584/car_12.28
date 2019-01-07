/**
 * 金融mapper接口
 */
package com.jk.car.mapper;

import com.jk.car.model.BorrowerBean;

public interface LoansMapper {

    /**
     * 新增 贷款人
     * @param borrower
     */
    void saveBorrwer(BorrowerBean borrower);
}
