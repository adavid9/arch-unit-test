package pl.dawidantecki.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * @author: Dawid Antecki
 * @created: 03/19/2021 6:54 PM
 * @version: 1.0
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "pl.dawidantecki.arch")
public class InterfaceRulesTest {

    @ArchTest
    public static final ArchRule interfaces_should_not_have_names_ending_with_the_word_interface =
            classes().that().areInterfaces().should().haveNameNotMatching(".*Interface");

    @ArchTest
    public static final ArchRule interfaces_should_not_have_simple_class_names_containing_the_word_interface =
            classes().that().areInterfaces().should().haveSimpleNameNotContaining("Interface");

    @ArchTest
    public static final ArchRule interfaces_names_should_start_with_an_I_at_the_beginning =
            classes().that().areInterfaces().should().haveSimpleNameStartingWith("I");

    @ArchTest
    public static final ArchRule interfaces_should_not_be_placed_to_impl_package =
            classes().that().resideInAPackage("..impl..").should().notBeInterfaces();
}
