package biz.spring.core.utils;

import biz.spring.core.model.ControlObject;
import biz.spring.core.repository.ControlObjectRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.reflections.Reflections;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SecurityUtils {

    private static ControlObjectRepository controlObjectRepository = new ControlObjectRepository();

    public static void fillControlObject(String packagePrefix){
        List<ControlObject> controlObjects = controlObjectRepository.getAll();
        Set<Class<?>> controllerClasses = new Reflections(packagePrefix).getTypesAnnotatedWith(RestController.class);
        List<ControlObject> controlObjectApplication = controllerClasses.stream().map(controllerClass -> {
            String urlController = controllerClass.getAnnotation(RequestMapping.class).value()[0];
            return Arrays.asList(controllerClass.getDeclaredMethods()).stream()
                    .filter(co -> co.getDeclaredAnnotation(RequestMapping.class)!=null).map(method -> {
                ControlObject controlObject = new ControlObject();
                controlObject.setControlObjectUrl(urlController + method.getDeclaredAnnotation(RequestMapping.class).value()[0]);
                controlObject.setControlObjectName(method.getDeclaredAnnotation(Operation.class)==null?"":method.getDeclaredAnnotation(Operation.class).summary());
                return controlObject;
            }).collect(Collectors.toList());
        }).flatMap(List::stream).collect(Collectors.toList());
        controlObjectRepository.insert(controlObjectApplication.stream().filter(
                controlObject -> controlObjects.stream().noneMatch(controlObject::equals)).collect(Collectors.toList()));
    }
}
