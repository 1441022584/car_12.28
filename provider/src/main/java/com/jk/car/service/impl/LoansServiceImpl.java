/**
 * 金融接口实现类
 */
package com.jk.car.service.impl;

import com.jk.car.mapper.LoansMapper;
import com.jk.car.model.BorrowerBean;
import com.jk.car.service.LoansService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("loansService")
public class LoansServiceImpl implements LoansService {

   @Resource
   private LoansMapper loansMapper;

    /**
     * 新增贷款人
     * @param borrower
     */
    @Override
    public void saveBorrwer(BorrowerBean borrower) {
        loansMapper.saveBorrwer(borrower);
    }
}
