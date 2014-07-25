# AML Parser

## Usage

    final AML aml = createAML("rule rule_0446_HC4_DUCT01 extends MinMax {" +
            "ProductPUIDs = 989, 7393;" +
            "Max = 2;" +
            "}");

    final List<AMLObject> amlObjects = aml.getObjects();


## AMLObject

    rule rule_0446_HC4_DUCT01 extends MinMax {
         ProductPUIDs = 989, 7393;
         Max = 2;
    }

## AMLProperty

    ProductPUIDs = 989, 7393;

## AMLPropertyValue

property value can be single value or array of values

    Max = 2; // Single value

    ProductPUIDs = 989, 7393; // An array of values

