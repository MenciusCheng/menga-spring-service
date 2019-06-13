//package com.menga.mengaspringservice.service;
//
//import com.menga.mengaspringservice.dao.CodeParserRepository;
//import com.menga.mengaspringservice.domain.CodeParser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
///**
// * Created by Marvel on 19/05/10.
// */
//@Service
//@Transactional
//public class CodeParserServiceImpl implements CodeParserService {
//    private final CodeParserRepository codeParserRepository;
//
//    @Autowired
//    public CodeParserServiceImpl(CodeParserRepository codeParserRepository) {
//        this.codeParserRepository = codeParserRepository;
//    }
//
//    @Override
//    public CodeParser saveCodeParser(CodeParser codeParser) {
//        return codeParserRepository.save(codeParser);
//    }
//
//    @Override
//    public CodeParser findCodeParserById(Integer id) {
//        return codeParserRepository.findById(id).orElse(new CodeParser());
//    }
//
//    @Override
//    public List<CodeParser> findAllCodeParsers() {
//        return codeParserRepository.findAll();
//    }
//}
