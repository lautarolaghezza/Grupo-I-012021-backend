package ar.edu.unq.desapp.grupoi.backenddesappapi.service;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.valoration.ValorationRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.valorationService.ValorationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValorationServiceTest {

    @Mock
    private ValorationRepository valorationRepository;

    private List<Valoration> valorations;
    private ValorationService valorationService;
    private Valoration valoration;

    @BeforeEach
    public void setup(){
        this.valorations = new ArrayList<>();
        MockitoAnnotations.initMocks(this);
        this.valoration = new Valoration(1L,
                                    2L,
                                    "true",
                                    true,
                                    1);
        valorationService = new ValorationService(valorationRepository);
        valorations.add(valoration);
        valorationService.addValoration(valoration);
    }
    @Test
    public void getValorationsTest(){
        Mockito.doReturn(valorations).when(valorationRepository).findAll();
        Assertions.assertEquals(1, valorationService.getValorations().size());
    }
    @Test
    public void getValorationByIdTest(){
        Mockito.doReturn(valorations.get(0)).when(valorationRepository).findById(1L);
        Assertions.assertEquals(1L, valorationService.getValorationById(1L).getId());

    }
    @Test
    public void getValorationsOfReviewTest(){
        Mockito.doReturn(valorations.stream().
                                     filter( v -> v.getReview_id() == 2)
                                     .collect(Collectors.toList()))
                .when(valorationRepository).findByReview_id(2L);
        Assertions.assertEquals(1, valorationService.getValorationsOfReview(2L).size());
    }
    @Test
    public void addValorationTest(){
        Valoration newValoration = new Valoration(2L,
                2L,
                "true",
                true,
                2);
        Mockito.doReturn(valorations.add(newValoration)).when(valorationRepository).save(newValoration);
        Mockito.doReturn(valorations).when(valorationRepository).findAll();
        Assertions.assertEquals(2, valorationService.getValorations().size());

    }
}
