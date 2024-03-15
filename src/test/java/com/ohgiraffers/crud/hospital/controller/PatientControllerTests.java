package com.ohgiraffers.crud.hospital.controller;

import com.ohgiraffers.crud.configuration.application.CrudHomeworkApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@ContextConfiguration(classes={CrudHomeworkApplication.class})
public class PatientControllerTests {
    @Autowired
    private PatientController patientController;
    private MockMvc mockMvc;
    @BeforeEach
    private void setUp(){mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
    }

    @Test
    public void 환자_전체_조회_컨트롤러_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/selectAll"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("result/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 환자_정보_추가_컨트롤러_테스트() throws Exception {
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("patientName","테스트용 환자");
        params.add("patientAge","26");
        params.add("patientGender","남");
        params.add("patientPhone","010-1234-5678");
        params.add("patientEmail","eurxxxx@naver.com");
        params.add("patientSick","편도염");
        params.add("patientAdmission","Y");
        params.add("departmentCode","3");
        mockMvc.perform(MockMvcRequestBuilders.post("/patient/insert").params(params))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/patient/selectAll"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print());
    }
}
