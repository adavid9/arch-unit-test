package pl.dawidantecki.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


/**
 * @author: Dawid Antecki
 * @created: 03/19/2021 8:27 PM
 * @version: 1.0
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "pl.dawidantecki.arch")
public class LayeredRulesTest {

    @ArchTest
    public static final ArchRule validate_layered_architecture =
            layeredArchitecture()
                    .layer("Entity").definedBy("..entity..")
                    .layer("Domain").definedBy("..domain..")
                    .layer("Repository").definedBy("..repository..")
                    .layer("Service").definedBy("..service..")
                    .layer("Controller").definedBy("..controller..")
                    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                    .whereLayer("Domain").mayOnlyBeAccessedByLayers("Controller", "Service")
                    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                    .whereLayer("Entity").mayOnlyBeAccessedByLayers("Repository", "Service");
}
