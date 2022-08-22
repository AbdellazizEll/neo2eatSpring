package com.jwtproject.userSecurity.Service.Impl;


import com.jwtproject.userSecurity.Entity.Category;
import com.jwtproject.userSecurity.Entity.Plat;
import com.jwtproject.userSecurity.Repository.PlatRepository;
import com.jwtproject.userSecurity.Service.PlatSer;
import com.jwtproject.userSecurity.enums.PlatStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PlatService implements PlatSer {

    @Autowired
    CategoryService categoryService;
    @Autowired
    PlatRepository platRepository;




    @Override
    public Plat findOne(long platId)
    {
    Plat platInfo = platRepository.findByPlatId(platId);

    return platInfo;
    }

    @Override
    public Page<Plat> findAll(Pageable pageable) {

         return  platRepository.findAll(pageable);
    }

    @Override
    public Page<Plat> findUpAll(Pageable pageable) {
        return platRepository.findAllByPlatStatusOrderByProductIdAsc(PlatStatusEnum.UP.getCode(),pageable);

    }

    @Override
    public Page<Plat>findPlatByAllInCategory(Category category, Pageable pageable) {
        return platRepository.findAllByCategoryTypeOrderByProductIdAsc(category.getPlat().getCategory(),pageable );
    }

    @Override
    public Page<Plat> findPlatByStatus(Integer platstatus, Pageable pageable) {
        return null;
    }


    @Override
    public Plat update(Plat platInfo) {

        // if null throw exception
        categoryService.findByCategoryType(platInfo.getCategory().getNomCat());
        if(platInfo.getPlatStatus() > 1) {
            throw new PlatNotFoundException(PlatStatusEnum.DOWN.getMessage());
        }


        return platRepository.save(platInfo);
    }

    @Override
    public Plat save(Plat platInfo) {
        return update(platInfo);

    }

    @Override
    public void delete(long platId) {
        Plat platInfo = findOne(platId);
        if (platInfo == null) throw new PlatNotFoundException(PlatStatusEnum.DOWN.getMessage());
        platRepository.delete(platInfo);

    }


}
 class PlatNotFoundException extends RuntimeException {
    public PlatNotFoundException(String message) {
        super(message);
    }


}