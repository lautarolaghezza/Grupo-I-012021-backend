package ar.edu.unq.desapp.grupoi.backenddesappapi.architecture;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class ArchitectureTest {
    JavaClasses importedClasses;

    @BeforeEach
    public void setUp() {
        importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupoi.backenddesappapi");
    }

    @Test
    public void restControllersHaveHisAnnotation() {
        ArchRule rule = classes().that().resideInAPackage("..webservices..").should().beAnnotatedWith(RestController.class);

        rule.check(importedClasses);
    }

    @Test
    public void controllersNotThrowsExceptions() {
        ArchRule rule = methods().that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class).should().notDeclareThrowableOfType(Exception.class);

        rule.check(importedClasses);
    }

}
