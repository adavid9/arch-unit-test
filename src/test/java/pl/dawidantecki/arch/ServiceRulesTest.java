package pl.dawidantecki.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * @author: Dawid Antecki
 * @created: 03/19/2021 7:26 PM
 * @version: 1.0
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "pl.dawidantecki.arch")
public class ServiceRulesTest {

    @ArchTest
    public static final ArchRule services_should_end_with_the_word_service =
            classes().that().resideInAPackage("..service").should().haveNameMatching(".*Service");

    @ArchTest
    public static final ArchRule services_should_be_interfaces = classes().that().resideInAPackage("..service")
            .should().beInterfaces();

    @ArchTest
    public static final ArchRule services_interfaces_should_not_be_placed_to_impl_package =
            classes().that().resideInAPackage("..service.impl").should().notBeInterfaces();
}
