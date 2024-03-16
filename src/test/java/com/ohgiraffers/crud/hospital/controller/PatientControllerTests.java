package com.ohgiraffers.crud.hospital.controller;

import com.ohgiraffers.crud.configuration.application.CrudHomeworkApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
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

    @Test
    @DisplayName("식별자로 환자 정보 조회해오는 테스트")
    public void selectOne() throws Exception {
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("patientCode","3");
        mockMvc.perform(MockMvcRequestBuilders.post("/patient/selectOne").params(param))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/result/one"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @DisplayName("환자의 정보를 수정하는 테스트")
    public void updatePatient() throws Exception {
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("patientAge","5");
        param.add("patientName","고동환");
        mockMvc.perform(MockMvcRequestBuilders.post("/patient/updateOne").params(param))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/patient/selectAll"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @DisplayName("식별자로 환자 정보 삭제")
    public void deleteOne() throws Exception {
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("patientCode","4");
        mockMvc.perform(MockMvcRequestBuilders.post("/patient/deleteOne").params(param))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/patient/selectAll"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print());
    }
}
