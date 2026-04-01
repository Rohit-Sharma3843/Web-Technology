<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
        <head>
            <title>Employee Details</title>
            <style>
                table {
                    width: 80%;
                    margin: 20px auto;
                    border-collapse: collapse;
                    font-family: Arial, sans-serif;
                }
                th, td {
                    border: 1px solid #2a5298;
                    padding: 12px;
                    text-align: left;
                }
                th {
                    background-color: #1e3c72;
                    color: white;
                }
                tr:nth-child(even) {
                    background-color: #e3ebf6;
                }
                h2 {
                    text-align: center;
                    color: #1e3c72;
                    font-family: Arial, sans-serif;
                }
            </style>
        </head>
        <body>
            <h2>Employee Information</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Position</th>
                    <th>Salary</th>
                </tr>
                <xsl:for-each select="employees/employee">
                    <tr>
                        <td><xsl:value-of select="id"/></td>
                        <td><xsl:value-of select="name"/></td>
                        <td><xsl:value-of select="department"/></td>
                        <td><xsl:value-of select="position"/></td>
                        <td><xsl:value-of select="salary"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>