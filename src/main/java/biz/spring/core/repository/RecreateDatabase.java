package biz.spring.core.repository;

import biz.spring.core.repository.dnk.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RecreateDatabase {

    @Autowired
    private AccessRoleRepository accessRoleRepository;
    @Autowired
    private ControlObjectRepository controlObjectRepository;
    @Autowired
    private ProgUserRepository progUserRepsitory;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private DocumentTransitRepository documentTransitRepository;
    @Autowired
    private DocumentRealRepository documentRealRepository;
    @Autowired
    private CapClassRepository capClassRepository;
    @Autowired
    private CapClassTypeRepository capClassTypeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private StudyCaseRepository studyCaseRepository;
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestPosRepository requestPosRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public void recreate(){
        TableRepository[] repositories = {
                progUserRepsitory,
                accessRoleRepository,
                controlObjectRepository,
                documentTypeRepository,
                documentTransitRepository,
                documentRealRepository,
                capClassRepository,
                capClassTypeRepository,
                companyRepository,
                addressRepository,
                capClassTypeRepository,
                documentRealRepository,
                studyProgramRepository,
                peopleRepository,
                directionRepository,
                studyCaseRepository,
                blockRepository,
                activityRepository,
                serviceRepository,
                requestRepository,
                requestPosRepository,
                newsRepository,
                attendanceRepository,
                scheduleRepository
                //TODO регистрация репозитория. Строго в порядке создания таблиц
        };
        Arrays.stream(repositories).forEach(repo->{
            repo.drop();
            repo.create();
            repo.load();
        });
    }
}
